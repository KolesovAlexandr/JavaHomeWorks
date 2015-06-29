package MyGameColumns;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class StateTest {

	private State _state;
	private Logic _logic;

	@Before
	public void setup() {
		_state = new State();
		_logic = new Logic(_state);
		Field field = new Field(7, 15);
		Figure figure = new Figure();
		_state.setField(field);
		_state.setFigure(figure);
	}

	@Test
	public void testSetFigure() {
		assertEquals(0, _state.row);
		assertEquals(3, _state.col);
	}

	@Test
	public void testMoveLeft() throws Exception {
		int col = _state.col;
		_logic.moveLeft();
		assertEquals(col - 1, _state.col);

	}

	@Test
	public void testMoveRight() throws Exception {
		int col = _state.col;
		_logic.moveRight();
		assertEquals(col + 1, _state.col);

	}

	@Test
	public void testMoveLeftTooFar() throws Exception {
		_state._figure = Figure.randomFigure();
		_state.col = 0;
		_logic.moveLeft();
		assertEquals(0, _state.col);
	}

	@Test
	public void testMoveRightTooFar() throws Exception {
		_state._figure = Figure.randomFigure();
		_state.col = _state._field.getWidth() - 1;
		int col = _state.col;
		_logic.moveRight();
		assertEquals(col, _state.col);
	}

	@Test
	public void testFigureDoesntFitField() throws Exception {
		_state._figure = Figure.randomFigure();
		_state.col = -1;
		assertFalse(_logic.isFigureFitsField());
		_state.col = 0;
		assertTrue(_logic.isFigureFitsField());
	}

	@Test
	public void testCyclePositionDown() throws Exception {
		_state._figure = Figure.testFigure();
		int[] data = _state._figure._data;
		int tmpFigure[] = new int[3];
		for (int i = 0; i < tmpFigure.length; i++) {
			tmpFigure[i] = data[i];
		}
		_logic.cyclePositionDown();
		assertEquals(tmpFigure[2], data[0]);
		assertEquals(tmpFigure[0], data[1]);
		assertEquals(tmpFigure[1], data[2]);
	}

	@Test
	public void testCyclePositionUp() throws Exception {
		_state._figure = Figure.testFigure();
		int[] data = _state._figure._data;
		int tmpFigure[] = new int[3];
		for (int i = 0; i < tmpFigure.length; i++) {
			tmpFigure[i] = data[i];
		}
		_logic.cyclePositionUp();
		assertEquals(tmpFigure[1], data[0]);
		assertEquals(tmpFigure[2], data[1]);
		assertEquals(tmpFigure[0], data[2]);
	}

	@Test
	public void testMoveDown() throws Exception {
		_state._figure = Figure.testFigure();
		int row = _state.row;
		_logic.moveDown();
		assertEquals(row + 1, _state.row);
	}

	@Test
	public void testMoveDownTooFar() throws Exception {
		_state._figure = Figure.testFigure();
		_state.row = _state._field.getHeight() - 3;
		assertTrue(_logic.isFigureFitsField());
		_logic.moveDown();
		assertTrue(_logic.isFigureFitsField());
		assertEquals(_state._field.getHeight() - 3, _state.row);

	}

	@Test
	public void testFigureOverlapsFieldContent() throws Exception {
		_state._figure = Figure.testFigure();
		_state._field._data[3][_state.col] = 1;
		_logic.moveDown();
		assertTrue(_logic.isFigureFitsField());
		assertEquals(0, _state.row);

	}
}
