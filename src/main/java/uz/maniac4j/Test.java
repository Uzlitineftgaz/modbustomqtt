package uz.maniac4j;


import uz.maniac4j.storm.modbus.client.ModbusClient;
import uz.maniac4j.storm.modbus.exceptions.ModbusStormException;
import uz.maniac4j.storm.modbus.server.ModbusServer;

import java.util.Arrays;
import java.util.Random;


public class Test {
    public static void main(String[] args) {
//        ModbusServer server=new ModbusServer();
//        server.setPort(9090);
//        server.setName("Simulator");
//        server.start();
//        System.out.println(Arrays.toString(server.inputRegisters));
//        System.out.println(Arrays.toString(server.holdingRegisters));
        ModbusServer modbusServer = new ModbusServer();
        modbusServer.setName("name");
        modbusServer.setPort(502);


//Note that Standard Port for Modbus TCP communication is 502



        modbusServer.coils[1] = true;

//
//        modbusServer.holdingRegisters[19] = 16710;
//        modbusServer.holdingRegisters[20] = 26214;
//        modbusServer.inputRegisters[19]=16710;
//        modbusServer.inputRegisters[20]=26214;
        modbusServer.start();
//        modbusServer.

        System.out.println(modbusServer);
//        modbusServer.

        try {
            modbusServer.Listen();
            System.out.println(Arrays.stream(modbusServer.inputRegisters).count());
            System.out.println(Arrays.toString(new int[]{modbusServer.inputRegisters[19]}));
            System.out.println(Arrays.toString(new int[]{modbusServer.holdingRegisters[19]}));
            System.out.println(modbusServer.holdingRegisters.length);
            System.out.println(Arrays.toString(modbusServer.getLogData()));


//            while (true){
//                String[] array = {"Rep-TT-001", "142-P-9518953", "159-P-9303983", "151-P-9303975", "85-P-9303928", "156-P-9303927", "Rep-P-9303835", "Rep-P-9303689", "BVN-P-9303677", "4K-P-9301307", "2oc-P-0215136","127-PT-0627923","138-PT-8874679"};
//                int temp=1;
//                for (String s : array) {
//                    for (int i = 0; i < 4; i++) {
//                        modbusServer.inputRegisters[temp]=16710;
//                        modbusServer.inputRegisters[temp+1]=26214;
//                        temp+=2;
//                    }
//                }
//
//                while (true){
//                    Random random=new Random(1000);
//                    int i = random.nextInt();
//                    int i2 = random.nextInt();
//                    modbusServer.inputRegisters[10]=i;
//                    modbusServer.inputRegisters[11]=i2;
//                    Thread.sleep(1000);
//                }
//            }

//            ModbusClient client=new ModbusClient("10.10.24.52",502);
//            client.Connect();
//            for (int i = 0; i < 1000; i++) {
//                int[] ints = client.ReadHoldingRegisters(i, 2);
//                System.out.println(Arrays.toString(ints));
//                System.out.println(ModbusClient.ConvertRegistersToFloat(ints));;
//                System.out.println(i);
//            }
        }
        catch (java.io.IOException e) {

        }
    }
}
