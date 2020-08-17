package com.cos.googleapp.config;

import org.springframework.context.annotation.Configuration;

import io.sentry.Sentry;
import io.sentry.event.Event;
import io.sentry.event.EventBuilder;

// index 탈 때마다 new 할 수 없기 때문에 여기로 다 때림
@Configuration
public class SentrySupport {

	public SentrySupport() { // DSN 주소 넣기
		System.out.println("============================SentrySupport init()============================");
		Sentry.init("https://aea0051976354c3a988ed638206bd925@o434906.ingest.sentry.io/5392550");
	}
	
	public void logSimpleMessage(String msg) {
		// This sends an event to Sentry.
		EventBuilder eventBuilder = new EventBuilder()
				.withMessage(msg)
				.withLevel(Event.Level.ERROR)
				.withLogger(SentrySupport.class.getName());

		// Note that the *unbuilt* EventBuilder instance is passed in so that
		// EventBuilderHelpers are run to add extra information to your event.
		Sentry.capture(eventBuilder); // capture = send 소켓통신을 통해 날림
	}
}
