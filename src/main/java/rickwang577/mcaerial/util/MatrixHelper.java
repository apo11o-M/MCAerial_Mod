package rickwang577.mcaerial.util;

import java.util.Arrays;

import net.minecraft.util.math.MathHelper;



/**
 * A simple matrix helper class that contains the three rotation matrices and 
 * a matrix multiplication method.
 * <p>
 * One thing to note is that the three axis of the rotation matrices are like
 * so: x→ z↗ y↑, which is different from the conventional axis system x→ y↗ z↑. 
 * 
 * @author rickwang577 
 */

public class MatrixHelper {
	
	/**
	 * Multiply two matrices and return the product
	 * 
	 * @param m1 The first matrix
	 * @param m2 The second matrix
	 */
	public static double[][] multiplyMatrix(double[][] m1, double[][] m2) {
		int r1 = m1.length, c1 = m1[0].length;
		int c2 = m2[0].length;
		
		double result[][] = new double[r1][c2]; 
		for(int i = 0; i < r1; i++) {
			for(int j = 0; j < c2; j++) {
				for(int k = 0; k < c1; k++) {
					result[i][j] += m1[i][k] * m2[k][j];
				}
			}
		}
		return result;
	}
	
	public static double getX(double[][] input) {
		return input[0][0];
	}
	
	public static double getY(double[][] input) {
		return input[2][0];
	}
	
	public static double getZ(double[][] input) {
		return input[1][0];
	}
	
	/**
	 * Basic rotation matrix about the x axis
	 * <pre> |‾  1    0     0   ‾| 
	 * |   0   cosθ -sinθ  | 
	 * |_  0   sinθ  cosθ _| </pre>
	 * 
	 * @param angle Rotation of an angle around the x axis
	 */
	public static double[][] rotateXMatrix(float angle) {
		double[][] m = {{1, 0, 0}, {0, MathHelper.cos(angle), -MathHelper.sin(angle)}, {0, MathHelper.sin(angle), MathHelper.cos(angle)}};
		return m;
		/*
		 	|‾  1    0     0   ‾|
		 	|   0   cosθ -sinθ  |
		 	|_  0   sinθ  cosθ _|
		 */	
	}
	
	/**
	 * Basic rotation matrix about the z axis 
	 *  <pre> |‾  cosθ   0  sinθ ‾|
 	 * |    0     1    0   |
 	 * |_ -sinθ   0  cosθ _| </pre>
	 * 
	 * @param angle Rotation of an angle around the z axis
	 */
	public static double[][] rotateZMatrix(float angle) {
		double[][] m = {{MathHelper.cos(angle), 0, MathHelper.sin(angle)}, {0, 1, 0}, {-MathHelper.sin(angle), 0, MathHelper.cos(angle)}};
		return m;
		/*
	 		|‾  cosθ   0  sinθ ‾|
 			|    0     1    0   |
 			|_ -sinθ   0  cosθ _|
		 */
	}
	
	/**
	 * Basic rotation matrix about the y axis
	 *  <pre> |‾  cosθ -sinθ  0  ‾|
 	 * |   sinθ  cosθ  0   |
 	 * |_   0     0    1  _| </pre>
 	 * 
	 * @param angle Rotation of an angle around the y axis
	 */
	public static double[][] rotateYMatrix(float angle) {
		double[][] m = {{MathHelper.cos(angle), -MathHelper.sin(angle), 0}, {MathHelper.sin(angle), MathHelper.cos(angle), 0}, {0, 0, 1}};
		return m;
		/*
 			|‾  cosθ -sinθ  0  ‾|
 			|   sinθ  cosθ  0   |
 			|_   0     0    1  _|
	 	 */
	}
	
		
	private static double sin(float angle) {
		return Math.sin(angle);
	}
	
	private static double cos(float angle) {
		return Math.cos(angle);
	}
	
	// roll yaw pitch
	public static double[][] rotationMatrixXYZ(float r, float p, float y) {
		double[][] m = {
			{cos(y) * cos(p), -sin(y), cos(y) * sin(p)},
			{cos(r) * sin(y) * cos(p) + sin(r) * sin(p), cos(r) * cos(y), cos(r) * sin(y) * sin(p) - sin(r) * cos(p)},
			{sin(r) * sin(y) * cos(p) - cos(r) * sin(p), sin(r) * cos(y), sin(r) * sin(y) * sin(p) + cos(r) * cos(p)}
		};		
		return m;
	}
	
	// roll pitch yaw
	public static double[][] rotationMatrixXZY(float r, float p, float y) {
		double[][] m = {
			{},
			{},
			{}
		};
		return m;		
	}

	public static double[][] rotationMatrixXYX(float r, float p, float y) {
		double[][] m = {
			{cos(y), -cos(p) * sin(y), sin(y) * sin(p)},
			{cos(r) * sin(y), cos(r) * cos(y) * cos(p) - sin(r) * sin(p), -cos(p) * sin(r) - cos(r) * cos(y) * sin(p)},
			{sin(r) * sin(y), sin(p) * cos(r) + sin(r) * cos(p) * cos(y), cos(r) * cos(p) - cos(y) * sin(r) * sin(p)}
		};		
		return m;
	}
	
	// pitch yaw roll
	public static double[][] rotationMatrixZYX(float r, float p, float y) {
		double[][] m = {
			{cos(r) * cos(y), sin(r) * sin(p) - cos(r) * cos(p) * sin(y), cos(p) * sin(r) + cos(r) * sin(y) * sin(p)},
			{sin(y), cos(y) * cos(p), -cos(y) * sin(p)},
			{-cos(y) * sin(r), cos(r) * sin(p) + cos(p) * sin(r) * sin(y), cos(r) * cos(p) - sin(r) * sin(p) * sin(y)},	
		};
		return m;
	}
	
	// yaw pitch roll
	public static double[][] rotationMatrixYZX(float r, float p, float y) {
		double[][] m = {
			{cos(y) * cos(p), cos(y) * sin(p) * sin(r) - cos(r) * sin(y), sin(y) * sin(r) + cos(y) * cos(r) * sin(p)},
			{cos(p) * sin(y), cos(y) * cos(r) + sin(y) * sin(p) * sin(r), cos(r) * sin(y) * sin(p) - cos(y) * sin(r)},
			{-sin(p), cos(p) * sin(r), cos(p) * sin(r)}
		};
		return m;
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
