package com.contusfly.groupmention;

import androidx.annotation.NonNull;


/**
 * Describes a configuration of mention for user.
 *
 * */
public class UserMentionConfig {

    private final String trigger;
    private String delimiter;

    private UserMentionConfig(@NonNull String trigger) {
        super();
        this.trigger = trigger;
    }

    /**
     * Returns trigger text for mention.
     *
     * @return A text of trigger.
     * @since 3.0.0
     */
    @NonNull
    public String getTrigger() {
        return trigger;
    }

    /**
     * Returns mention delimiter string.
     *
     * @return mention delimiter string.
     * */
    @NonNull
    public String getDelimiter() {
        return delimiter;
    }

    public static class Builder {

        public Builder() {
            /**
             * Not used for now
             */
        }

        /**
         * Creates an {@link UserMentionConfig} with the arguments supplied to this builder.
         *
         * @return The {@link UserMentionConfig}.
         **/
        @NonNull
        public UserMentionConfig build() {
            UserMentionConfig params = new UserMentionConfig("@");
            params.delimiter = " ";
            return params;
        }
    }
}
