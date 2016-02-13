
package generadorcodigo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author GONZALO DAVID PROAÑO
 */
public class Generador {
    
    String simbolos[];

    public Generador() {
        this.simbolos=new String[100];
    }

    
    public void genrator()
    {
        String salida="";
    String datos ;
    String acumulador;
    String acumulador1;
    String acumulador2;
        
        datos=JOptionPane.showInputDialog("INGRESE EL STRING");
        StringTokenizer tokens=new StringTokenizer(datos);
	for(int i=0;i<simbolos.length&&tokens.hasMoreTokens();i++)
	{
                                String s2;
				s2 = tokens.nextToken();
                                this.simbolos[i]=s2;

                
                if(this.simbolos[i]!=null)
                {
                    Pattern pat = Pattern.compile("1|2|3|4|5|6|7|8|9");
                                
				Matcher mat = pat.matcher(s2);
                         
				if (mat.matches()==true)
				{
                                    
                                    acumulador=this.simbolos[i];
                                    
                                     salida+="\r\n"+"li $a0 "+acumulador;
                                    
				} else
                                
                                {
                                acumulador1="\r\n"+"sw $a0 0($sp)";
                                acumulador2="\r\n"+"addiu $sp $sp 4";
                                salida+=acumulador1+acumulador2;
                                }              
        }	
      }
        String instruccion= "\r\n"+"add $a0 $a0 4($sp)";
        String instruccion1="\r\naddiu $sp $sp 4";
        String instruccion3="\r\nlw $t1 4($sp)";
        String instruccion2="\r\nsub $a0 $a0 $t1";
        salida+=instruccion+instruccion1+instruccion3+instruccion2;
         
                   
        JOptionPane.showMessageDialog(null, salida);
        try{
            String direccion1="C:\\Users\\DAVID PROAÑO\\Desktop\\salida.txt";
		
		File abrir=new File (direccion1);
		FileWriter  w=new FileWriter(abrir);
		BufferedWriter bw = new BufferedWriter(w);
		PrintWriter wr =new PrintWriter(bw);
                	
		wr.write(salida);
                
            
		wr.close();
		bw.close();
	}catch(Exception ex)
	{
		JOptionPane.showMessageDialog(null, "La direccion del archivo esta incorrecta");
	}
        }
    }