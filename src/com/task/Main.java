package com.task;

public class Main {

	enum Direction {
		NORTH, SOUTH, EAST, WEST;

		public Direction turnLeft() {
			return values()[(ordinal() + 3) % values().length];
		}

		public Direction turnRight() {
			return values()[(ordinal() + 1) % values().length];
		}
	}

	private static int x = 0;
	private static int y = 0;
	private static Direction direction = Direction.NORTH;

	public static void main(String[] args) {
		if (args.length != 0) {
			moveCommand(args[0]);
			displayResult();
		} else {
			System.out.println("No movement instructions passed.");
		}
	}

	private static void moveCommand(String inputCommand) {
		for (char command : inputCommand.toCharArray()) {
			switch (command) {
			case 'L':
				direction = direction.turnLeft();
				break;
			case 'R':
				direction = direction.turnRight();
				break;
			case 'M':
				int steps = readSteps(inputCommand);
				move(steps);
				break;
			}
		}
	}

	private static void move(int steps) {
		switch (direction) {
		case NORTH -> y += steps;
		case EAST -> x += steps;
		case SOUTH -> y -= steps;
		case WEST -> x -= steps;
		}
	}

	private static int readSteps(String inputCommand) {
		String stepsStr = inputCommand.replaceAll("\\D", "");
		return stepsStr.isEmpty() ? 0 : Integer.parseInt(stepsStr);
	}

	private static void displayResult() {
		System.out.println(direction + " (" + x + "," + y + ")");
	}
}
