package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Grava e depois lê dados binários.
public final class RWData {

	public static void main(String[] args) {
		
		int i = 10;
		double d = 1023.56;
		boolean b = true;
		
		// gravando dados (data recording)
		try(DataOutputStream dataout = new DataOutputStream(new FileOutputStream("testdata"))) {
			
			System.out.println("Writing " + i);
			dataout.writeInt(i);
			
			System.out.println("Writing " + d);
			dataout.writeDouble(d);
			
			System.out.println("Writing " + b);
			dataout.writeBoolean(b);
			
			System.out.println("Writing " + 12.2 * 7.4);
			dataout.writeDouble(12.2 * 7.4);
			
		} catch (IOException e) {
			System.out.println("Error I/O: Write error " + e.getMessage());
			return;
		}
		
		System.out.println();
		
		//lendo dados (data reading)
		
		try(DataInputStream dataIn = new DataInputStream(new FileInputStream("testdata"))) {
			
			i = dataIn.readInt();
			System.out.println("Reading " + i);
			
			d = dataIn.readDouble();
			System.out.println("Reading " + d);
			
			b = dataIn.readBoolean();
			System.out.println("Reading " + b);
			
			d = dataIn.readDouble();
			System.out.println("Reading " + d);
			
		} catch (IOException exc) {
			System.out.println("Read error !!");
		}
		
	}//main
}//class
