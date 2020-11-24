package com.android.systemui.qs.tiles;

import android.app.ActivityManager;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.Switch;

import com.android.systemui.R;
import com.android.systemui.qs.QSTile;
import com.android.systemui.statusbar.phone.PhoneStatusBar;
import com.android.systemui.statusbar.policy.NavigationBarController;

public class NavigationBarTile extends QSTile<QSTile.BooleanState> {
    private final AnimationIcon mEnable
            = new AnimationIcon(R.drawable.ic_signal_flashlight_enable_animation,
            R.drawable.ic_signal_flashlight_disable);
    private final AnimationIcon mDisable
            = new AnimationIcon(R.drawable.ic_signal_flashlight_disable_animation,
            R.drawable.ic_signal_flashlight_enable);
    private final NavigationBarController mNavigationBarController = null;

    public NavigationBarTile(Host host) {
        super(host);
    }

    @Override
    protected void handleDestroy() {
        super.handleDestroy();
    }

    @Override
    public BooleanState newTileState() {
        return new BooleanState();
    }

    @Override
    protected void handleClick() {

    }

    @Override
    protected void handleUpdateState(BooleanState state, Object arg) {
        state.label = "NavigationBar";
        final int value = arg instanceof Integer ? (Integer)arg : mSetting.getValue();
        final boolean airplaneMode = value != 0;
        state.value = airplaneMode;
        state.label = mContext.getString(R.string.airplane_mode);
        if (airplaneMode) {
            state.icon = mEnable;
        } else {
            state.icon = mDisable;
        }
        state.contentDescription = state.label;
        state.minimalAccessibilityClassName = state.expandedAccessibilityClassName
                = Switch.class.getName();
    }

    @Override
    public int getMetricsCategory() {
        return -1;
    }

    @Override
    public Intent getLongClickIntent() {
        return null;
    }

    @Override
    protected void setListening(boolean listening) {

    }

    @Override
    public CharSequence getTileLabel() {
        return "NavigationBar";
    }
}
