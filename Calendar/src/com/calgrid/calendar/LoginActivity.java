package com.calgrid.calendar;

import java.io.IOException;

import android.os.Bundle;
import android.os.Handler;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.view.Menu;

public class LoginActivity extends Activity {

	AccountManager amgr;
	Account[] acc;
	
	private class OnTokenAcquired implements AccountManagerCallback<Bundle> {
	    public void run(AccountManagerFuture<Bundle> result) {
	        // Get the result of the operation from the AccountManagerFuture.
	        Bundle bundle = null;
			try {
				bundle = result.getResult();
			} catch (OperationCanceledException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (AuthenticatorException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	        // The token is a named value in the bundle. The name of the value
	        // is stored in the constant AccountManager.KEY_AUTHTOKEN.
	        String token = bundle.getString(AccountManager.KEY_AUTHTOKEN);
	    }
	}
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        amgr.
        acc = amgr.getAccountsByType("com.google");
        amgr = AccountManager.get(this);
        Bundle options = new Bundle();
        amgr.getAuthToken(
        	    acc,                     // Account retrieved using getAccountsByType()
        	    "Manage your tasks",            // Auth scope
        	    options,                        // Authenticator-specific options
        	    this,                           // Your activity
        	    new OnTokenAcquired(),          // Callback called when a token is successfully acquired
        	    new Handler(new OnError()));    // Callback called if an error occurs
        setContentView(R.layout.activity_login);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_login, menu);
        return true;
    }
}
