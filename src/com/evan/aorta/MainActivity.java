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
	public TextView tes, tes2, tes3;
	public Animation slideUp,slideUp2;
	public String data;
	public String first, second, third = null;
	public char[] chars;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tes = (TextView)findViewById(R.id.tes);
		tes2 = (TextView)findViewById(R.id.tes2);
		tes3 = (TextView)findViewById(R.id.tes23);
		Typeface myTypeface = Typeface.createFromAsset(getAssets(), "lane.ttf");
	    tes.setTypeface(myTypeface);
	    tes2.setTypeface(myTypeface);
	    tes3.setTypeface(myTypeface);
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
		
		if (chars.length > 1){
    		if(!String.valueOf(chars[0]).equals("1")){  
    		    RelativeLayout.LayoutParams llp = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    		    llp.setMargins(0, 0, -2, 0); // llp.setMargins(left, top, right, bottom);
    		    tes.setLayoutParams(llp);
    		}
    	}
		
		slideUp.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) {
		    	
		    }           
		    @Override
		    public void onAnimationRepeat(Animation arg0) {
		    }           
		    @Override
		    public void onAnimationEnd(Animation arg0) {
		    	if (chars.length > 1)
		    		tes.setText(String.valueOf(chars[0]));
		    }
		});
		
		slideUp2.setAnimationListener(new Animation.AnimationListener(){
		    @Override
		    public void onAnimationStart(Animation arg0) {
		    	
		    }           
		    @Override
		    public void onAnimationRepeat(Animation arg0) {
		    }           
		    @Override
		    public void onAnimationEnd(Animation arg0) {
		    	if (chars.length > 1)
		    		tes2.setText(String.valueOf(chars[1]));
		    	else
		    		tes2.setText(String.valueOf(chars[0]));
		    }
		});
		
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
		            	
		            	if (chars.length > 1){
		            		
		            		if (first == null){
		            			tes.startAnimation(slideUp);
		            			first = String.valueOf(chars[0]);
		            		}else{
			            		if (!first.equals(String.valueOf(chars[0]))){
			            			tes.startAnimation(slideUp);
			            			first = String.valueOf(chars[0]);
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
		            	tes2.startAnimation(slideUp2);
		            }
		        });
		    }
		}).start();
		
		time = 60 + (int)(Math.random() * ((99 - 60) + 1));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
