package Sudoku.test;

public class Sudoku {
	//Ejercicio realizado gracias a: https://www.instintoprogramador.com.mx/2019/08/resolviendo-sudoku-con-backtracking-c.html
	
	private  static  final  int  TAMAÑO  =  9 ; 
	private static int [][] sudoku = { 
		    	{ 6 , 5 , 0 , 8 , 7 , 3 , 0 , 9 , 0 }, 
		    	{ 0 , 0 , 3 , 2 , 5 , 0 , 0 , 0 , 8 }, 
		    	{ 9 , 8 , 0 , 1 , 0 , 4 , 3 , 5 , 7 }, 
		        { 1 , 0 , 5 , 0 , 0 , 0 , 0 , 0 , 0 }, 
		        { 4 , 0 , 0 , 0 , 0 , 0 , 0 , 0 , 2 }, 
		        { 0 , 0 , 0 , 0 , 0 , 0 , 5 , 0 , 3 }, 
		        { 5 , 7 , 8 , 3 , 0 , 1 , 0 , 2 , 6 }, 
		        { 2 , 0 , 0 , 0 , 4 , 8 , 9 , 0 , 0 }, 
		        { 0 , 9 , 0 , 6 , 2 , 5 , 0 , 8 , 1 } 
    };
		
	
	/**
	 * Metodo principal que invoca los otros metodos
	 * @param args
	 */
	public static void main(String[] args) {
		if  ( resolverSudoku ()) 
            System.out.println(imprimirSudoku ()); 
		else
            System.out.println( "Sin solución" ); 
	}
	/**
     * Metodo para resolver sudoku 
     * usando backtracking 
     * @return true o false
     */
    private static boolean  resolverSudoku () 
    { 
        int  fila = 0 ; 
        int  col = 0 ; 
        int a [] =  asignarNumero ( fila ,  col ); 
        // si todas las celdas están asignadas, el sudoku ya está resuelto 
        // pasar por referencia porque numeroAsignado cambiará los valores de fila y col 
        if ( a [ 0 ]  ==  0 ) 
            return  true ;
        // número entre 1 y 9 
        fila  =  a [ 1 ]; 
        col  =  a [2 ]; 
        for ( int  i = 1 ; i <= TAMAÑO ; i ++){ 
            // si podemos asignar i a la celda o no 
            // la celda es sudoku [fila] [col] 
            if ( verificarCelda ( i ,  fila ,  col )){ 
                sudoku [ fila ] [ col ]  =  i ; 
                // retroceder 
                if( resolverSudoku ()) 
                    return  true ; 
                // si no podemos continuar con esta solución 
                // reasignar la 
                sudoku [ fila ] [ col ] = 0 ; 
            } 
        } 
        return  false ; 
    }
	 
 	/**
 	 *  Metodo para verificar si todas las celdas están asignadas o no 
 	 *  si hay alguna celda no asignada 
 	 *  entonces este metodo cambiará los valores de 
 	 *  fila y col en consecuencia 
 	 * @param fila
 	 * @param col
 	 * @return 
 	 */
    private static int []  asignarNumero ( int  fila ,  int  col ) 
    { 
        int  numeroAsignado  =  0 ; 
        for ( int  i = 0 ; i < TAMAÑO ; i ++) 
        { 
            for ( int  j = 0 ; j <TAMAÑO ; j ++) 
            { 
                // la celda no está asignada 
                if ( sudoku [ i ] [ j ]  ==  0 ) { 
                    // cambiando los valores de fila y columna 
                    fila  =  i ; 
                    col  =  j ; 
                    // hay una o más celdas sin asignar 
                    numeroAsignado  =  1 ; 
                    int []  a  =  { numeroAsignado ,  fila ,  col }; 
                    return  a ; 
                } 
            } 
        } 
        int [] a  =  { numeroAsignado, -1, -1}; 
        return a ; 
    }
    
    /**
     * Metodo para verificar si podemos poner un 
     * valor en una celda particular o no 
     * @param n
     * @param f
     * @param c
     * @return true or false
     */
    private static boolean verificarCelda ( int n , int f , int c ) { 
    	// comprobando en fila 
    	for ( int i = 0 ; i < TAMAÑO ; i ++) { 
    		// hay una celda con el mismo valor 
    		if ( sudoku [ f ] [ i ] == n ) {
    			return false ; }       
    	}
    	 // comprobando la columna 
        for ( int  i = 0 ; i < TAMAÑO ; i ++) 
        { 
            // hay una celda con el valor igual a i 
            if ( sudoku [ i ] [ c ]  ==  n ) 
                return  false ; 
        } 
        // comprobación de submatriz 
        int  inicioFila  =  ( f / 3 ) * 3 ; 
        int  inicioCol  =  ( c / 3 ) * 3 ;
        for ( int  i = inicioFila ; i < inicioFila + 3 ; i ++) 
        { 
            for ( int  j = inicioCol ; j < inicioCol + 3 ; j ++) 
            { 
                if ( sudoku [ i ] [ j ] == n ) 
                    return  false ; 
            } 
        } 
        return  true ; 
    }
    
    /**
	 * Metodo que imprime el sudoku resuelto
	 * @return sudoku
	 */
	 private static  String imprimirSudoku () { 
		 String salida = "";
	        for ( int  i = 0 ; i < TAMAÑO ; i ++) { 
	            for ( int  j = 0 ; j < TAMAÑO ; j ++) { 
	                salida += sudoku[i][j] + " ";
	            } 
	           salida += "\n";
	        } 
	        return salida;
	    }
}
