package jvmparse.parse.factory;

import jvmparse.parse.ClassBuffer;
import jvmparse.parse.entity.instruction.*;

/**
 * InstructionFactory
 *
 * @author chenzb
 * @date 2019/11/20
 */
public class InstructionFactory {

    public static final short NOP              = 0;
    public static final short ACONST_NULL      = 1;
    public static final short ICONST_M1        = 2;
    public static final short ICONST_0         = 3;
    public static final short ICONST_1         = 4;
    public static final short ICONST_2         = 5;
    public static final short ICONST_3         = 6;
    public static final short ICONST_4         = 7;
    public static final short ICONST_5         = 8;
    public static final short LCONST_0         = 9;
    public static final short LCONST_1         = 10;
    public static final short FCONST_0         = 11;
    public static final short FCONST_1         = 12;
    public static final short FCONST_2         = 13;
    public static final short DCONST_0         = 14;
    public static final short DCONST_1         = 15;
    public static final short BIPUSH           = 16;
    public static final short SIPUSH           = 17;
    public static final short LDC              = 18;
    public static final short LDC_W            = 19;
    public static final short LDC2_W           = 20;
    public static final short ILOAD            = 21;
    public static final short LLOAD            = 22;
    public static final short FLOAD            = 23;
    public static final short DLOAD            = 24;
    public static final short ALOAD            = 25;
    public static final short ILOAD_0          = 26;
    public static final short ILOAD_1          = 27;
    public static final short ILOAD_2          = 28;
    public static final short ILOAD_3          = 29;
    public static final short LLOAD_0          = 30;
    public static final short LLOAD_1          = 31;
    public static final short LLOAD_2          = 32;
    public static final short LLOAD_3          = 33;
    public static final short FLOAD_0          = 34;
    public static final short FLOAD_1          = 35;
    public static final short FLOAD_2          = 36;
    public static final short FLOAD_3          = 37;
    public static final short DLOAD_0          = 38;
    public static final short DLOAD_1          = 39;
    public static final short DLOAD_2          = 40;
    public static final short DLOAD_3          = 41;
    public static final short ALOAD_0          = 42;
    public static final short ALOAD_1          = 43;
    public static final short ALOAD_2          = 44;
    public static final short ALOAD_3          = 45;
    public static final short IALOAD           = 46;
    public static final short LALOAD           = 47;
    public static final short FALOAD           = 48;
    public static final short DALOAD           = 49;
    public static final short AALOAD           = 50;
    public static final short BALOAD           = 51;
    public static final short CALOAD           = 52;
    public static final short SALOAD           = 53;
    public static final short ISTORE           = 54;
    public static final short LSTORE           = 55;
    public static final short FSTORE           = 56;
    public static final short DSTORE           = 57;
    public static final short ASTORE           = 58;
    public static final short ISTORE_0         = 59;
    public static final short ISTORE_1         = 60;
    public static final short ISTORE_2         = 61;
    public static final short ISTORE_3         = 62;
    public static final short LSTORE_0         = 63;
    public static final short LSTORE_1         = 64;
    public static final short LSTORE_2         = 65;
    public static final short LSTORE_3         = 66;
    public static final short FSTORE_0         = 67;
    public static final short FSTORE_1         = 68;
    public static final short FSTORE_2         = 69;
    public static final short FSTORE_3         = 70;
    public static final short DSTORE_0         = 71;
    public static final short DSTORE_1         = 72;
    public static final short DSTORE_2         = 73;
    public static final short DSTORE_3         = 74;
    public static final short ASTORE_0         = 75;
    public static final short ASTORE_1         = 76;
    public static final short ASTORE_2         = 77;
    public static final short ASTORE_3         = 78;
    public static final short IASTORE          = 79;
    public static final short LASTORE          = 80;
    public static final short FASTORE          = 81;
    public static final short DASTORE          = 82;
    public static final short AASTORE          = 83;
    public static final short BASTORE          = 84;
    public static final short CASTORE          = 85;
    public static final short SASTORE          = 86;
    public static final short POP              = 87;
    public static final short POP2             = 88;
    public static final short DUP              = 89;
    public static final short DUP_X1           = 90;
    public static final short DUP_X2           = 91;
    public static final short DUP2             = 92;
    public static final short DUP2_X1          = 93;
    public static final short DUP2_X2          = 94;
    public static final short SWAP             = 95;
    public static final short IADD             = 96;
    public static final short LADD             = 97;
    public static final short FADD             = 98;
    public static final short DADD             = 99;
    public static final short ISUB             = 100;
    public static final short LSUB             = 101;
    public static final short FSUB             = 102;
    public static final short DSUB             = 103;
    public static final short IMUL             = 104;
    public static final short LMUL             = 105;
    public static final short FMUL             = 106;
    public static final short DMUL             = 107;
    public static final short IDIV             = 108;
    public static final short LDIV             = 109;
    public static final short FDIV             = 110;
    public static final short DDIV             = 111;
    public static final short IREM             = 112;
    public static final short LREM             = 113;
    public static final short FREM             = 114;
    public static final short DREM             = 115;
    public static final short INEG             = 116;
    public static final short LNEG             = 117;
    public static final short FNEG             = 118;
    public static final short DNEG             = 119;
    public static final short ISHL             = 120;
    public static final short LSHL             = 121;
    public static final short ISHR             = 122;
    public static final short LSHR             = 123;
    public static final short IUSHR            = 124;
    public static final short LUSHR            = 125;
    public static final short IAND             = 126;
    public static final short LAND             = 127;
    public static final short IOR              = 128;
    public static final short LOR              = 129;
    public static final short IXOR             = 130;
    public static final short LXOR             = 131;
    public static final short IINC             = 132;
    public static final short I2L              = 133;
    public static final short I2F              = 134;
    public static final short I2D              = 135;
    public static final short L2I              = 136;
    public static final short L2F              = 137;
    public static final short L2D              = 138;
    public static final short F2I              = 139;
    public static final short F2L              = 140;
    public static final short F2D              = 141;
    public static final short D2I              = 142;
    public static final short D2L              = 143;
    public static final short D2F              = 144;
    public static final short I2B              = 145;
    public static final short I2C              = 146;
    public static final short I2S              = 147;
    public static final short LCMP             = 148;
    public static final short FCMPL            = 149;
    public static final short FCMPG            = 150;
    public static final short DCMPL            = 151;
    public static final short DCMPG            = 152;
    public static final short IFEQ             = 153;
    public static final short IFNE             = 154;
    public static final short IFLT             = 155;
    public static final short IFGE             = 156;
    public static final short IFGT             = 157;
    public static final short IFLE             = 158;
    public static final short IF_ICMPEQ        = 159;
    public static final short IF_ICMPNE        = 160;
    public static final short IF_ICMPLT        = 161;
    public static final short IF_ICMPGE        = 162;
    public static final short IF_ICMPGT        = 163;
    public static final short IF_ICMPLE        = 164;
    public static final short IF_ACMPEQ        = 165;
    public static final short IF_ACMPNE        = 166;
    public static final short GOTO             = 167;
    public static final short JSR              = 168;
    public static final short RET              = 169;
    public static final short TABLESWITCH      = 170;
    public static final short LOOKUPSWITCH     = 171;
    public static final short IRETURN          = 172;
    public static final short LRETURN          = 173;
    public static final short FRETURN          = 174;
    public static final short DRETURN          = 175;
    public static final short ARETURN          = 176;
    public static final short RETURN           = 177;
    public static final short GETSTATIC        = 178;
    public static final short PUTSTATIC        = 179;
    public static final short GETFIELD         = 180;
    public static final short PUTFIELD         = 181;
    public static final short INVOKEVIRTUAL    = 182;
    public static final short INVOKESPECIAL    = 183;
    public static final short INVOKESTATIC     = 184;
    public static final short INVOKEINTERFACE  = 185;
    public static final short NEW              = 187;
    public static final short NEWARRAY         = 188;
    public static final short ANEWARRAY        = 189;
    public static final short ARRAYLENGTH      = 190;
    public static final short ATHROW           = 191;
    public static final short CHECKCAST        = 192;
    public static final short INSTANCEOF       = 193;
    public static final short MONITORENTER     = 194;
    public static final short MONITOREXIT      = 195;
    public static final short WIDE             = 196;
    public static final short MULTIANEWARRAY   = 197;
    public static final short IFNULL           = 198;
    public static final short IFNONNULL        = 199;
    public static final short GOTO_W           = 200;
    public static final short JSR_W            = 201;


    public Instruction getInstruction(ClassBuffer buffer) {
        int opcode = buffer.u1();
        switch (opcode) {
            case NOP:
                return null;
            case ACONST_NULL:
                return null;
            case ICONST_M1:
                return null;
            case ICONST_0:
                return null;
            case ICONST_1:
                return null;
            case ICONST_2:
                return null;
            case ICONST_3:
                return null;
            case ICONST_4:
                return null;
            case ICONST_5:
                return null;
            case LCONST_0:
                return null;
            case LCONST_1:
                return null;
            case FCONST_0:
                return null;
            case FCONST_1:
                return null;
            case FCONST_2:
                return null;
            case DCONST_0:
                return new DConst.DConst0(opcode);
            case DCONST_1:
                return new DConst.DConst1(opcode);
            case BIPUSH:
                return null;
            case SIPUSH:
                return null;
            case LDC:
                return new Ldc(buffer, opcode);
            case LDC_W:
                return null;
            case LDC2_W:
                return null;
            case ILOAD:
                return null;
            case LLOAD:
                return null;
            case FLOAD:
                return null;
            case DLOAD:
                return null;
            case ALOAD:
                return new ALoad(buffer, opcode);
            case ILOAD_0:
                return new ALoad.ALoad0(opcode);
            case ILOAD_1:
                return new ALoad.ALoad1(opcode);
            case ILOAD_2:
                return new ALoad.ALoad2(opcode);
            case ILOAD_3:
                return new ALoad.ALoad3(opcode);
            case LLOAD_0:
                return null;
            case LLOAD_1:
                return null;
            case LLOAD_2:
                return null;
            case LLOAD_3:
                return null;
            case FLOAD_0:
                return null;
            case FLOAD_1:
                return null;
            case FLOAD_2:
                return null;
            case FLOAD_3:
                return null;
            case DLOAD_0:
                return null;
            case DLOAD_1:
                return null;
            case DLOAD_2:
                return null;
            case DLOAD_3:
                return null;
            case ALOAD_0:
                return new ALoad.ALoad0(opcode);
            case ALOAD_1:
                return new ALoad.ALoad1(opcode);
            case ALOAD_2:
                return new ALoad.ALoad2(opcode);
            case ALOAD_3:
                return new ALoad.ALoad3(opcode);
            case IALOAD:
                return null;
            case LALOAD:
                return null;
            case FALOAD:
                return null;
            case DALOAD:
                return null;
            case AALOAD:
                return null;
            case BALOAD:
                return null;
            case CALOAD:
                return null;
            case SALOAD:
                return null;
            case ISTORE:
                return null;
            case LSTORE:
                return null;
            case FSTORE:
                return null;
            case DSTORE:
                return null;
            case ASTORE:
                return null;
            case ISTORE_0:
                return null;
            case ISTORE_1:
                return null;
            case ISTORE_2:
                return null;
            case ISTORE_3:
                return null;
            case LSTORE_0:
                return null;
            case LSTORE_1:
                return null;
            case LSTORE_2:
                return null;
            case LSTORE_3:
                return null;
            case FSTORE_0:
                return null;
            case FSTORE_1:
                return null;
            case FSTORE_2:
                return null;
            case FSTORE_3:
                return null;
            case DSTORE_0:
                return null;
            case DSTORE_1:
                return null;
            case DSTORE_2:
                return null;
            case DSTORE_3:
                return null;
            case ASTORE_0:
                return null;
            case ASTORE_1:
                return null;
            case ASTORE_2:
                return null;
            case ASTORE_3:
                return null;
            case IASTORE:
                return null;
            case LASTORE:
                return null;
            case FASTORE:
                return null;
            case DASTORE:
                return null;
            case AASTORE:
                return null;
            case BASTORE:
                return null;
            case CASTORE:
                return null;
            case SASTORE:
                return null;
            case POP:
                return null;
            case POP2:
                return null;
            case DUP:
                return null;
            case DUP_X1:
                return null;
            case DUP_X2:
                return null;
            case DUP2:
                return null;
            case DUP2_X1:
                return null;
            case DUP2_X2:
                return null;
            case SWAP:
                return null;
            case IADD:
                return null;
            case LADD:
                return null;
            case FADD:
                return null;
            case DADD:
                return null;
            case ISUB:
                return null;
            case LSUB:
                return null;
            case FSUB:
                return null;
            case DSUB:
                return null;
            case IMUL:
                return null;
            case LMUL:
                return null;
            case FMUL:
                return null;
            case DMUL:
                return null;
            case IDIV:
                return null;
            case LDIV:
                return null;
            case FDIV:
                return null;
            case DDIV:
                return null;
            case IREM:
                return null;
            case LREM:
                return null;
            case FREM:
                return null;
            case DREM:
                return null;
            case INEG:
                return null;
            case LNEG:
                return null;
            case FNEG:
                return null;
            case DNEG:
                return null;
            case ISHL:
                return null;
            case LSHL:
                return null;
            case ISHR:
                return null;
            case LSHR:
                return null;
            case IUSHR:
                return null;
            case LUSHR:
                return null;
            case IAND:
                return null;
            case LAND:
                return null;
            case IOR:
                return null;
            case LOR:
                return null;
            case IXOR:
                return null;
            case LXOR:
                return null;
            case IINC:
                return null;
            case I2L:
                return null;
            case I2F:
                return null;
            case I2D:
                return null;
            case L2I:
                return null;
            case L2F:
                return null;
            case L2D:
                return null;
            case F2I:
                return null;
            case F2L:
                return null;
            case F2D:
                return null;
            case D2I:
                return null;
            case D2L:
                return null;
            case D2F:
                return null;
            case I2B:
                return null;
            case I2C:
                return null;
            case I2S:
                return null;
            case LCMP:
                return null;
            case FCMPL:
                return null;
            case FCMPG:
                return null;
            case DCMPL:
                return null;
            case DCMPG:
                return null;
            case IFEQ:
                return null;
            case IFNE:
                return null;
            case IFLT:
                return null;
            case IFGE:
                return null;
            case IFGT:
                return null;
            case IFLE:
                return null;
            case IF_ICMPEQ:
                return null;
            case IF_ICMPNE:
                return null;
            case IF_ICMPLT:
                return null;
            case IF_ICMPGE:
                return null;
            case IF_ICMPGT:
                return null;
            case IF_ICMPLE:
                return null;
            case IF_ACMPEQ:
                return null;
            case IF_ACMPNE:
                return null;
            case GOTO:
                return null;
            case JSR:
                return null;
            case RET:
                return null;
            case TABLESWITCH:
                return null;
            case LOOKUPSWITCH:
                return null;
            case IRETURN:
                return null;
            case LRETURN:
                return null;
            case FRETURN:
                return null;
            case DRETURN:
                return null;
            case ARETURN:
                return null;
            case RETURN:
                return new Return(opcode);
            case GETSTATIC:
                return null;
            case PUTSTATIC:
                return null;
            case GETFIELD:
                return null;
            case PUTFIELD:
                return new PutField(buffer, opcode);
            case INVOKEVIRTUAL:
                return null;
            case INVOKESPECIAL:
                return new InvokeSpecial(buffer, opcode);
            case INVOKESTATIC:
                return null;
            case INVOKEINTERFACE:
                return null;
            case NEW:
                return null;
            case NEWARRAY:
                return null;
            case ANEWARRAY:
                return null;
            case ARRAYLENGTH:
                return null;
            case ATHROW:
                return null;
            case CHECKCAST:
                return null;
            case INSTANCEOF:
                return null;
            case MONITORENTER:
                return null;
            case MONITOREXIT:
                return null;
            case WIDE:
                return null;
            case MULTIANEWARRAY:
                return null;
            case IFNULL:
                return null;
            case IFNONNULL:
                return null;
            case GOTO_W:
                return null;
            case JSR_W:
                return null;
            default:
                return null;
        }
    }
}
