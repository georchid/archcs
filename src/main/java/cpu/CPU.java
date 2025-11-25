package cpu;

import app.EmulationAbortException;
import cpu.interrupts.InterruptVectorTable;
import cpu.interrupts.exceptions.InterruptException;
import cpu.interrupts.exceptions.UnknownInstructionException;
import cpu.ports.Port;
import instructions.Instruction;
import memory.RAM;
import memory.registers.ProgramCounter;
import memory.registers.Register32;
import memory.registers.StatusRegister;
import operands.Operands;

import java.util.ArrayList;
import java.util.List;

public class CPU {
    public final List<Register32> intRegs;
    public final List<Register32> floatRegs;
    public final ProgramCounter programCounter;
    public final StatusRegister statusReg;
        public final Register32 returnAddressRegister;
    public final RAM memory;
    public final Port port;
    private final InterruptVectorTable ivt;
    private boolean isProgramEnd;

    public static final int INT_REGS_COUNT = 32;
    public static final int FLOAT_REGS_COUNT = 32;
    public static final int MEMORY_SIZE = 1024;
    public static final int PROTECTED_MEMORY_SIZE = MEMORY_SIZE / 2;

    public CPU() {
        intRegs = new ArrayList<>(INT_REGS_COUNT);
        for (int count = 0; count < INT_REGS_COUNT; ++count)
            intRegs.add(new Register32());

        floatRegs = new ArrayList<>(FLOAT_REGS_COUNT);
        for (int count = 0; count < FLOAT_REGS_COUNT; ++count)
            floatRegs.add(new Register32());

        programCounter = new ProgramCounter();
        statusReg = new StatusRegister();
        memory = new RAM(MEMORY_SIZE);
        ivt = new InterruptVectorTable();
        port = new Port();
        returnAddressRegister = new Register32();
        isProgramEnd = false;
    }

    public boolean nextInstruction() throws EmulationAbortException {
        if (!isProgramEnd) {
            try {
                int instructionData = memory.getWord(programCounter.postIncrementToNextInstruction());
                int opcode = instructionData >>> (Instruction.SIZE - Instruction.OPCODE_SIZE);
                if (opcode != 0) {
                    int operandsData = instructionData << Instruction.OPCODE_SIZE;
                    Instruction instruction = Instruction.fromOpcode(opcode);
                    if (instruction == null) {
                        throw new UnknownInstructionException("Unknown instruction requested");
                    }
                    instruction.execute(this, Operands.createForInstruction(instruction, operandsData));
                } else {
                    isProgramEnd = true;
                }
            } catch (InterruptException e) {
                if (!e.isMaskable() || statusReg.getFlagStatus(Flag.INTERRUPT)) {
                    ivt.getInterruptHandler(e.getVector()).handle(this);
                }
            }
        }
        return isProgramEnd;
    }

    public void clear() {
        for (var reg : intRegs)
            reg.clear();

        for (var reg : floatRegs)
            reg.clear();

        programCounter.clear();
        statusReg.clear();
        memory.clear();
        isProgramEnd = false;
    }
}
