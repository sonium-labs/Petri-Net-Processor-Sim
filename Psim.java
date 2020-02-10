import java.util.*;
import java.io.*;

class inm {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * Source Operand - String 4. Second Source Operand - String
     */
    private String opcode;
    private String destination;
    private String source1;
    private String source2;

    public String getOpcode() {
        return this.opcode;
    }

    public void setOpcode(String opcode) {
        this.opcode = opcode;
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getSource1() {
        return this.source1;
    }

    public void setSource1(String source1) {
        this.source1 = source1;
    }

    public String getSource2() {
        return this.source2;
    }

    public void setSource2(String source2) {
        this.source2 = source2;
    }
}

class inb {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class aib {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class sib {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class prb {
    /*
     * 4 attributes: 1. Opcode - String 2. Destination register - String 3. First
     * source value - int 4. Second source value - int
     */
}

class adb {
    /*
     * 2 attributes: 1. Register name - String 2. Data memory address - int
     */
}

class reb {
    /*
     * 2 attributes: 1. register name - String 2. register value - int
     */
}
// class rgf
// {
// /*
// 2 attributes:
// 1. register name - String
// 2. register value - int
// */
// }

// class dam
// {
// /*
// 2 attributes:
// 1. address - int
// 2. value - int
// */
// }

public class Psim {
    public static void main(String[] args) {
        // Read in files
        File instructions = new File("instructions.txt");
        File registers = new File("registers.txt");
        File datamemory = new File("datamemory.txt");

        // Instantiate places

        ///////////////////////// INSTRUCTION MEMORY/////////////////////////
        inm inm[] = new inm[16]; // Declaraing instruction memory array (INM)

        INMsetup(instructions, inm);

        // DEBUG: CHECK INM ARRAY
        for (int i = 0; i < 16; i++) {
            System.out.println("Your OPCODE at INM " + i + " is " + inm[i].getOpcode());
            // System.out.println("Your OPCODE at INM is " + inm[0].getOpcode());
        }
        //////////////////////////

        /////////////////////////REGISTER FILE///////////////////////////////
        int[] rgf = new int[16]; // Instantiating register file place (RGF)
        // TODO: read in register values

        RGFsetup(registers, rgf);

        // DEBUG: CHECK RGF ARRAY
       
        for (int j = 0; j < 16; j++) {
            System.out.println("Your DATA at R" + j + " is " + rgf[j]);
            // System.out.println("Your OPCODE at INM is " + inm[0].getOpcode());
        }
        //////////////////////////

        /////////////////////////DATA MEMORY/////////////////////////////////
        int[] dam = new int[16]; // Instantiating data memory place (DAM)

        DAMsetup(datamemory, dam);

        // TODO: read in data values

        //////////////////////////

        ///////////////////////// TRANSITIONS/////////////////////////
        // TODO: READ/DECODE

        // TODO: ISSUE1
        // TODO: ISSUE2
        // TODO: ASU (add/sub unit)
        // TODO: MLU1
        // TODO: MLU2
        // TODO: ADDR (address calculation)
        // TODO: STORE
        // TODO: WRITE

    }

    public static void INMsetup(File instructions, inm[] inm) {
        for (int i = 0; i < inm.length; i++) { // Creating INM objects
            inm[i] = new inm();
        }

        int instCount = 0;

        // read
        try {
            Scanner scan = new Scanner(instructions);

            while (scan.hasNextLine()) {
                if (instCount > 16) {
                    System.out.println("Too many instructions! Only 16 instructions can be inputted at once.");
                    System.exit(1);
                }
                // Parses input and places each segment into temporary array
                String[] temp = scan.nextLine().replaceAll("\\<", "").replaceAll("\\>", "").split(",");
                // Accesses temp array to set values in INM
                inm[instCount].setOpcode(temp[0]); 
                inm[instCount].setDestination(temp[1]);
                inm[instCount].setSource1(temp[2]);
                inm[instCount].setSource2(temp[3]);

                instCount++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void RGFsetup(File registers, int[] rgf) {
        try {
            Scanner scan = new Scanner(registers);

            while (scan.hasNextLine()) {
                // Parses input and places each segment into temporary array
                String[] temp = scan.nextLine().replaceAll("\\<R", "").replaceAll("\\>", "").split(",");
                // Use temporary array to fill indexes with their proper values
                rgf[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void DAMsetup(File datamemory, int[] dam) {
        try {
            Scanner scan = new Scanner(datamemory);

            while (scan.hasNextLine()) {
                // Parses input and places each segment into temporary array
                String[] temp = scan.nextLine().replaceAll("\\<", "").replaceAll("\\>", "").split(",");
                // Use temporary array to fill indexes with their proper values
                dam[Integer.parseInt(temp[0])] = Integer.parseInt(temp[1]);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}