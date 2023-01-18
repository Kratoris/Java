/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empresaxyz;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jose Luis
 */
public class EmpresaXYZ {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean continuar = true;
        int opcion=0, seleccion=0;
        ArrayList<Secretario> secretarios = new ArrayList<Secretario>();
        ArrayList<Vendedor> vendedores = new ArrayList<Vendedor>();
        ArrayList<JefeZona> jefes = new ArrayList<JefeZona>();
        
        ArrayList<Coche> coches = new ArrayList<Coche>();
        
        coches.add(new Coche("GSY404","NISSAN","KICKS 2020"));
        coches.add(new Coche("KQC402","HONDA","CIVIC 2021"));
        coches.add(new Coche("IZN408","CHEVROLET","SAIL 2020"));
        coches.add(new Coche("GHK401","KIA","PICANTO 2020"));
        
        secretarios.add(new Secretario("OFI 402","+57 6658541","Juanito","Perez","6666666","Cra 44","318652321",1000000));
        secretarios.add(new Secretario("OFI 301","+57 6652541","Andrea","Marquez","316254521","Cra 66","3186543212",1200000));

        vendedores.add(new Vendedor(coches.get(0),"318654211","Zona norte",2,"Andres","Martinez","164525871","Calle 44","31565454",900000));
        vendedores.add(new Vendedor(coches.get(1),"321542152","Zona centro",2,"Pablo","Milanes","112212151","Calle 66","31832541",900000));
        vendedores.add(new Vendedor(coches.get(2),"320221211","Zona sur",2,"Martin","Garcia","11182548451","Calle 42","3162121",900000));

        jefes.add(new JefeZona(secretarios.get(0),coches.get(3),"Rodolfo","Payan","1118542545","Calle 55","3165426598",2500000));
        
        do{
         
        try{ 
          opcion = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione La tarea a realizar:"
            +"1. Añadir Vendedor\n "
            +"2. Cambiar Secretario\n"
            +"3. Cambiar coche\n "
            +"4. Imprimir Jefes\n "
            +"5. Salir "
            
            ));
          
        }catch(NumberFormatException n){
            JOptionPane.showMessageDialog(null,"Debe ingresar un valor numerico");
        }
          switch(opcion){
              case 1:
                  String l="";
                  int pos =1;
                  for(Vendedor v: vendedores){
                      l +=pos+"- "+v.getNombre()+" "+v.getApellido()+"\n";
                      pos++;
                  }
                  try{
                      seleccion = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione el vendedor: \n"+ l));
                      jefes.get(0).agregarVendedor( vendedores.get(seleccion-1));
                   }catch(NumberFormatException n){
                       JOptionPane.showMessageDialog(null,"Debe ingresar un valor numerico");
                   }
                   catch(IndexOutOfBoundsException e){
                        JOptionPane.showMessageDialog(null,"Valor ingresado fuera del rango de la lista de vendedores");
                   }

               break;
               
              case 2:
                   String s="";
                  int poss =1;
                  for(Secretario sec: secretarios){
                      s +=poss+"- "+sec.getNombre()+" "+sec.getApellido()+"\n";
                      poss++;
                  }
                  seleccion = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione el secretario: \n"+ s));
                  jefes.get(0).setSecreatario(secretarios.get(seleccion-1));
                  
              break;
              
              case 3:
                   String c="";
                  int posc =1;
                  for(Coche coche: coches){
                      c +=posc+"- "+coche.getMatricula()+" "+coche.getModelo()+"\n";
                      posc++;
                  }
                  seleccion = Integer.parseInt(JOptionPane.showInputDialog(null,"Seleccione el coche: \n"+ c));
                  jefes.get(0).setCoche(coches.get(seleccion-1));
             break;
             
              case 4:
                  for(JefeZona j : jefes){
                     j.imprimir();
                  }
                  
              break;
              case 5:
                 continuar= false;        
              break;     
          }
           
            
        }while(continuar);
        
        
    }
    
}
