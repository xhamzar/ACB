package com.example.accessibilitybridge;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.util.Log;

public class AccessibilityBridgeService extends AccessibilityService {

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        Log.d("BridgeService", "Event: " + event.toString());
    }

    @Override
    public void onInterrupt() {
        Log.d("BridgeService", "Service interrupted");
    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d("BridgeService", "Accessibility Service Connected");
        new Thread(() -> {
            SocketServer.startServer();
        }).start();
    }
}
