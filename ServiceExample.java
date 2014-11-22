/* ------------------------------------------------- MyService.java------------------------------------------------------------------- */
 
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;
 
public class MyService extends Service {
        private static final String TAG = "MyService";
        MediaPlayer player;
       
        @Override
        public IBinder onBind(Intent intent) {
                return null;
        }
       
        @Override
        public void onCreate() {
                Toast.makeText(this, "My Service Created", Toast.LENGTH_LONG).show();
                // Aca se crea el servicio, pasa una sola vez
        }
 
        @Override
        public void onDestroy() {
                Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
                // Aca se destruye el servicio, pasa una sola vez
        }
       
        @Override
        public void onStart(Intent intent, int startid) {
                Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
                // Esto vendria a ser lo que se ejecuta, yo le pongo un timer y cada tanto hago algo
        }
}
 
/* ------------------------------------------------- Cancelar o iniciar ------------------------------------------------------------- */
 
startService(new Intent(this, MyService.class)); // Iniciar - start
stopService(new Intent(this, MyService.class)); // Destruir - stop
 
/* ------------------------------------------------------- Manifest ----------------------------------------------------------------- */
 
<service android:enabled="true" android:name=".MyService" /> // Adentro de <application> va esto - That goes inside <application>
