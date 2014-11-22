final Handler mHandler = new Handler();
       
int x; // milliseconds
new Thread(new Runnable() {
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (true) {
            try {
                Thread.sleep(x);
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        // Write your code here to update the UI.
                        
                    }
                });
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}).start();
