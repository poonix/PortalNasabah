package teknologi.azha.portaldebitur.model.annotation;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by user on 04/09/2017.
 */

@IntDef({
        ModulType.MODUL_HOME,
        ModulType.MODUL_REGISTRASI,
        ModulType.MODUL_AJUKAN,
        ModulType.MODUL_HISTORI,
        ModulType.MODUL_ANGSURAN
})
@Retention(RetentionPolicy.SOURCE)
public @interface ModulType {
    int MODUL_HOME = -1;
    int MODUL_REGISTRASI = 0;
    int MODUL_AJUKAN = 1;
    int MODUL_HISTORI = 2;
    int MODUL_ANGSURAN = 3;
}
