/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.sysds.test.functions.unary.matrix;

import org.junit.Test;
import org.apache.sysds.test.AutomatedTestBase;
import org.apache.sysds.test.TestConfiguration;



public class SinTest extends AutomatedTestBase 
{
	
	private static final String TEST_DIR = "functions/unary/matrix/";
	private static final String TEST_CLASS_DIR = TEST_DIR + SinTest.class.getSimpleName() + "/";
	private static final double EPS = 1e-14;
	
	@Override
	public void setUp() {
		addTestConfiguration("PositiveTest",
				new TestConfiguration(TEST_CLASS_DIR, "SinTest", new String[] { "vector", "matrix" }));
		addTestConfiguration("NegativeTest",
				new TestConfiguration(TEST_CLASS_DIR, "SinTest", new String[] { "vector", "matrix" }));
		addTestConfiguration("RandomTest",
				new TestConfiguration(TEST_CLASS_DIR, "SinTest", new String[] { "vector", "matrix" }));
	}
	
	@Test
	public void testPositive() {
		int rows = 10;
		int cols = 10;
		
		TestConfiguration config = availableTestConfigurations.get("PositiveTest");
		config.addVariable("rows", rows);
		config.addVariable("cols", cols);
		
		loadTestConfiguration(config);
		
		double[][] vector = getRandomMatrix(rows, 1, 0, 1, 1, -1);
		double[][] sinVector = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			sinVector[i][0] = Math.sin(vector[i][0]);
		}
		writeInputMatrix("vector", vector);
		writeExpectedMatrix("vector", sinVector);
		
		double[][] matrix = getRandomMatrix(rows, cols, 0, 1, 1, -1);
		double[][] sinMatrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sinMatrix[i][j] = Math.sin(matrix[i][j]);
			}
		}
		writeInputMatrix("matrix", matrix);
		writeExpectedMatrix("matrix", sinMatrix);
		
		runTest();
		
		compareResults(EPS);
	}
	
	@Test
	public void testNegative() {
		int rows = 10;
		int cols = 10;
		
		TestConfiguration config = availableTestConfigurations.get("NegativeTest");
		config.addVariable("rows", rows);
		config.addVariable("cols", cols);
		
		loadTestConfiguration(config);
		
		double[][] vector = getRandomMatrix(rows, 1, -1, 0, 1, -1);
		double[][] sinVector = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			sinVector[i][0] = Math.sin(vector[i][0]);
		}
		writeInputMatrix("vector", vector);
		writeExpectedMatrix("vector", sinVector);
		
		double[][] matrix = getRandomMatrix(rows, cols, -1, 0, 1, -1);
		double[][] sinMatrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sinMatrix[i][j] = Math.sin(matrix[i][j]);
			}
		}
		writeInputMatrix("matrix", matrix);
		writeExpectedMatrix("matrix", sinMatrix);
		
		runTest();
		
		compareResults(EPS);
	}
	
	@Test
	public void testRandom() {
		int rows = 10;
		int cols = 10;
		
		TestConfiguration config = availableTestConfigurations.get("RandomTest");
		config.addVariable("rows", rows);
		config.addVariable("cols", cols);
		
		loadTestConfiguration(config);
		
		double[][] vector = getRandomMatrix(rows, 1, -1, 1, 1, -1);
		double[][] sinVector = new double[rows][1];
		for(int i = 0; i < rows; i++) {
			sinVector[i][0] = Math.sin(vector[i][0]);
		}
		writeInputMatrix("vector", vector);
		writeExpectedMatrix("vector", sinVector);
		
		double[][] matrix = getRandomMatrix(rows, cols, -1, 1, 1, -1);
		double[][] sinMatrix = new double[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				sinMatrix[i][j] = Math.sin(matrix[i][j]);
			}
		}
		writeInputMatrix("matrix", matrix);
		writeExpectedMatrix("matrix", sinMatrix);
		
		runTest();
		
		compareResults(EPS);
	}
	
}
