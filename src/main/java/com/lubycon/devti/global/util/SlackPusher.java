package com.lubycon.devti.global.util;

import in.ashwanthkumar.slack.webhook.Slack;
import in.ashwanthkumar.slack.webhook.SlackMessage;
import java.io.IOException;

public class SlackPusher {

  private final Slack slack;

  public SlackPusher(String webhookUrl, String channel) {
    this.slack = new Slack(webhookUrl)
        .icon(":smiling_imp:") // Ref - http://www.emoji-cheat-sheet.com/
        .sendToChannel(channel)
        .displayName("DEVTI");
  }

  public void pushMessage(String message) {
    SlackMessage slackMessage = new SlackMessage(message);
    try {
      slack.push(slackMessage);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
