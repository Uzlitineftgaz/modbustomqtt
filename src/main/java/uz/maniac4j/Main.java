package uz.maniac4j;

import uz.maniac4j.storm.modbus.client.ModbusClient;
import uz.maniac4j.storm.modbus.exceptions.ModbusStormException;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException, ModbusStormException, InterruptedException {
        ModbusClient client=new ModbusClient("0.0.0.0",502);
        client.Connect();
        System.out.println(client.isConnected());
        for (int i = 0; i < 100; i++) {

            int[] ints = client.ReadInputRegisters(i+1, 2);
//            int[] ints2 = client.ReadHoldingRegisters(i, 2);
            System.out.println(Arrays.toString(ints));
//            System.out.println(Arrays.toString(ints2));
//
//            int[] ints2 = client.ReadInputRegisters(19, 2);
//            System.out.println(Arrays.toString(ints2));
//
//            int[] ints3 = client.ReadInputRegisters(29, 2);
//            System.out.println(Arrays.toString(ints3));
//
//            int[] ints4 = client.ReadInputRegisters(39, 2);
//            System.out.println(Arrays.toString(ints4));


            System.out.println(ModbusClient.ConvertRegistersToFloat(ints, ModbusClient.RegisterOrder.LowHigh));
//            System.out.println(ModbusClient.ConvertRegistersToFloat(ints2, ModbusClient.RegisterOrder.LowHigh));
//            System.out.println(ModbusClient.ConvertRegistersToFloat(ints3, ModbusClient.RegisterOrder.LowHigh));
//            System.out.println(ModbusClient.ConvertRegistersToFloat(ints4, ModbusClient.RegisterOrder.LowHigh));
//            Thread.sleep(1000);
        }



    }
}
