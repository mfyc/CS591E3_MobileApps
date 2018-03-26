'''
CS591 E3 Textbook Problems

Assignment 4

'''

'''
CHAPTER 3

'''
// 3.14
int rowSize = 4;
int columnSize = 2;

GridLayout gridLayout = new GridLayout(this);
gridLayout.setColumnCount(columnSize);
gridLayout.setRowCount(rowSize);


// 3.15
private Button button = new Button(this);


// 3.16
int btnRowSize = 5;
int btnColumnSize = 2;

private Button [][] buttons = new Button[btnRowSize][btnColumnSize];
for(int row = 0; row < btnRowSize; row++){
	for(int col = 0; col < btnColumnSize: col++) {
		// create the 5x2 2d array of buttons in current context
		buttons[row][col] = new Button(this);
		// add buttons to layout or something
	}
}


// 3.17
GridLayout gl = new GridLayout(this);
private Button b = new Button(this);
// width and height of screen size we want
int w = 200;

gl.addView(b,w,w);


// 3.21
private class ButtonHandler implements View.OnClickListener {
	public void onClick( View v ){
		// assuming b is an already created single button object
		if (v == b) {
			// w is an appropriate screen size to display the message
			Log.w("Yes");
		} else {
			Log.w("No");
		}
	}
}

'''
CHAPTER 7

'''


// 7.18
protected void onCreate( Bundle savedInstanceState ){
	super.onCreate( savedInstanceState );
	// Your code goes here
	setContentView(R.layout.activity_main);
	View view = findViewById(android.R.id.content);
	view.setOnTouchListener(this);

}


''' 
Detector is a private GestureDetector instance variable and the method is under MainActivity
class that extends AppCompatActivity and implements GestureDetector.OnGestureListener.

'''

// 7.19
public boolean onTouchEvent( MotionEvent event ){
	// Your code goes here
	detector.onTouchEvent(event);
	return true;
}