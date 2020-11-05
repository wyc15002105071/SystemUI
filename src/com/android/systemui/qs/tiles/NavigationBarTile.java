package com.android.systemui.qs.tiles;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.Switch;

import com.android.systemui.R;
import com.android.systemui.qs.QSTile;
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
        if (true) {
            Drawable icon = mHost.getContext().getDrawable(R.drawable.ic_signal_flashlight_disable)
                    .mutate();
            final int disabledColor = mHost.getContext().getColor(R.color.qs_tile_tint_unavailable);
            icon.setTint(disabledColor);
            state.icon = new DrawableIcon(icon);
            state.label = new SpannableStringBuilder().append(state.label,
                    new ForegroundColorSpan(disabledColor),
                    SpannableStringBuilder.SPAN_INCLUSIVE_INCLUSIVE);
            state.contentDescription = mContext.getString(
                    R.string.accessibility_quick_settings_flashlight_unavailable);
            return;
        }
        if (arg instanceof Boolean) {
            boolean value = (Boolean) arg;
            if (value == state.value) {
                return;
            }
            state.value = value;
        } else {
            state.value = false;
        }
        final AnimationIcon icon = state.value ? mEnable : mDisable;
        state.icon = icon;
        state.contentDescription = mContext.getString(R.string.quick_settings_flashlight_label);
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
