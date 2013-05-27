package com.evan.aorta;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.view.ViewPager.LayoutParams;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	public Handler mHandler = new Handler();
	public int time = 88;
	public TextView tes, tes2, tes3, tes23;
	public Animation slideUp,slideUp2, slideUp3;
	public String data;
	public String first, second, third = null;
	public char[] chars;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tes = (TextView)findViewById(R.id.tes);
		tes2 = (TextView)findViewById(R.id.tes2);
		tes3 = (TextView)findViewById(R.id.tes3);
		tes23 = (TextView)findViewById(R.id.tes23);
		Typeface myTypeface = Typeface.createFromAsset(getAssets(), "lane.ttf");
	    tes.setTypeface(myTypeface);
	    tes2.setTypeface(myTypeface);
	    tes3.setTypeface(myTypeface);
	    tes23.setTypeface(myTypeface);
		new Thread(new Runnable() {
	        @Override
	        public void run() {
	            while (true) {
	                try {
	                    Thread.sleep(2000);
	                    mHandler.post(new Runnable() {
	                        @Override
	                        public void run() {
	                            tes();
	                        }
	                    });
	                } catch (Exception e) {
	                    // TODO: handle exception
	                }
	            }
	        }
		}).start();
	}
	
	public void tes(){
		
		
		data = String.valueOf(time);
		chars = data.toCharArray();
		slideUp = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up);
		slideUp.setDuration(400);
		slideUp2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up);
		slideUp2.setDuration(400);
		slideUp3 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_up);
		slideUp3.setDuration(400);
		
		slideUp.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) {}           
		    @Override
		    public void onAnimationRepeat(Animation arg0) {}           
		    @Override
		    public void onAnimationEnd(Animation arg0) {
		    	if (chars.length == 3)
		    		tes.setText(String.valueOf(chars[0]));
		    	else
		    		tes.setText(" ");
		    }
		});
		
		slideUp2.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) {}           
		    @Override
		    public void onAnimationRepeat(Animation arg0) {}           
		    @Override
		    public void onAnimationEnd(Animation arg0) {
		    	if (chars.length == 2){
		    		tes2.setText(String.valueOf(chars[0]));
		    		tes.setText(" ");
		    	}
		    	else if (chars.length == 3)
		    		tes2.setText(String.valueOf(chars[1]));
		    }
		});
		
		slideUp3.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) {}           
		    @Override
		    public void onAnimationRepeat(Animation arg0) {}           
		    @Override
		    public void onAnimationEnd(Animation arg0) {
		    	if (chars.length == 2){
		    		tes3.setText(String.valueOf(chars[1]));
		    		tes.setText(" ");
		    	}
		    	else if (chars.length == 3)
		    		tes3.setText(String.valueOf(chars[2]));
		    	else{
		    		tes.setText(" ");
		    		tes3.setText(String.valueOf(chars[0]));
		    	}
		    }
		});
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        runOnUiThread(new Runnable() {
		            @Override
		            public void run() {
		            	try {
				            Thread.sleep(200);
				        } catch (InterruptedException e) {
				            e.printStackTrace();
				        }
		            	
		            	if (chars.length == 3){
		            		
//		            		if (first == null){
		            			tes.startAnimation(slideUp);
//		            			first = String.valueOf(chars[0]);
//		            		}else{
//			            		if (!first.equals(String.valueOf(chars[0]))){
//			            			tes.startAnimation(slideUp);
//			            			first = String.valueOf(chars[0]);
//			            		}
//		            		}
		            	}
//		            	else{
//		            		tes.setText(" ");
//		            	}
		            }
		        });
		    }
		}).start();
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        runOnUiThread(new Runnable() {
		            @Override
		            public void run() {
		            	try {
				            Thread.sleep(100);
				        } catch (InterruptedException e) {
				            e.printStackTrace();
				        }
		            	
		            	if (chars.length == 2){
		            		if (second == null){
		            			tes2.startAnimation(slideUp2);
		            			second = String.valueOf(chars[0]);
		            		}else{
			            		if (!second.equals(String.valueOf(chars[0]))){
			            			tes2.startAnimation(slideUp2);
			            			second = String.valueOf(chars[0]);
			            		}
		            		}
		            		
		            	}else if (chars.length == 3){
		            		if (second == null){
		            			tes2.startAnimation(slideUp2);
		            			second = String.valueOf(chars[1]);
		            		}else{
			            		if (!second.equals(String.valueOf(chars[1]))){
			            			tes2.startAnimation(slideUp2);
			            			second = String.valueOf(chars[1]);
			            		}
		            		}
		            	}
		            	
		            }
		        });
		    }
		}).start();
		
		new Thread(new Runnable() {
		    @Override
		    public void run() {
		        runOnUiThread(new Runnable() {
		            @Override
		            public void run() {
		            	tes3.startAnimation(slideUp3);
		            }
		        });
		    }
		}).start();
		
		time = 50 + (int)(Math.random() * ((260 - 50) + 1));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
