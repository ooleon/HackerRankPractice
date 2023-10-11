package temp;

import java.util.Iterator;

public class TetrisPrueba {

	char cuadro = '■';
	int filas = 10;
	int columnas = 5;
	char[][] grid = new char[filas][columnas];

	char[][] pieza = { { cuadro, cuadro, }, { cuadro, cuadro } };

	public static void main(String[] args) {
		TetrisPrueba c1 = new TetrisPrueba();
		c1.llenarCuadro();
		c1.dibujarPieza();
		c1.dibujarCuadro();
	}

	void dibujarPieza() {
		int positionf = 3;
		int positionc = 4;
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				if (f == positionf && c == positionc) {
					grid[f][c] = pieza[0][0];
				}
			}
		}
	}

	void llenarCuadro() {
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				grid[f][c] = ' ';
			}
		}
	}

	void dibujarCuadro() {
		for (int f = 0; f < filas; f++) {
			for (int c = 0; c < columnas; c++) {
				System.out.print(grid[f][c]);
			}
			System.out.println();
		}

	}

}
