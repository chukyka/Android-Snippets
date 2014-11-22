//delay in ms
        int DELAY = 3000;
 
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // esto va a pasar despues que el tiempo de DELAY termine
                //This will happen when the time finish
                Intent i = new Intent(getApplicationContext(), Final.class);
                startActivity(i);
                finish();
            }
        }, DELAY);
