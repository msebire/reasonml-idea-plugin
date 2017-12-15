package com.reason.ide;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationListener;
import com.intellij.notification.NotificationType;
import com.reason.icons.Icons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class RmlNotification extends Notification {

    private static final String REASON_ML_GROUP_DISPLAY = "ReasonML";

    public RmlNotification(@Nullable String title, @Nullable String subtitle, @Nullable String content, @NotNull NotificationType type, @Nullable NotificationListener listener) {
        super(REASON_ML_GROUP_DISPLAY, /*type == NotificationType.INFORMATION ? Icons.BLUE_FILE : (type == NotificationType.WARNING ? Icons.YELLOW_FILE : Icons.RML_FILE),*/ title, /*subtitle, */content, type, listener);
    }

    public RmlNotification(@NotNull String title, @NotNull String content, @NotNull NotificationType type) {
        super(REASON_ML_GROUP_DISPLAY, /*type == NotificationType.INFORMATION ? Icons.BLUE_FILE : (type == NotificationType.WARNING ? Icons.YELLOW_FILE : Icons.RML_FILE),*/ title, /*null,*/ content, type, null);
    }
}
