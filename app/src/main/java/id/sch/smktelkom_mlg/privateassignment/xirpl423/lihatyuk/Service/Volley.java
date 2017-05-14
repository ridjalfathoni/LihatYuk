package id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Service;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;

/**
 * Created by Ridjal Fathoni on 14/05/2017.
 */

public class Volley {
    private static volatile Volley mInst;
    private static Context mCon;
    private RequestQueue mRQ;

    private Volley(Context context) {
        if (mInst != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class");
        }
        mCon = context;
        mRQ = getRequestQueue();
    }

    public static Volley getInstance(Context context) {
        if (mInst == null) {
            synchronized (Volley.class) {
                if (mInst == null) mInst = new Volley(context);
            }
        }
        return mInst;
    }

    public RequestQueue getRequestQueue() {
        if (mRQ == null) {
            mRQ = com.android.volley.toolbox.Volley.newRequestQueue(mCon.getApplicationContext());
        }
        return mRQ;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}
