package com.sysdelphia.jsf;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class DebugPhaseListener implements PhaseListener {
	private static final Log log = LogFactory.getLog(DebugPhaseListener.class);

	public DebugPhaseListener() {
		log.debug("Constructor");
	}

	public void afterPhase(PhaseEvent phaseEvent) {
		log.debug("After phase: " + phaseEvent.getPhaseId());
	}

	public void beforePhase(PhaseEvent phaseEvent) {
		log.debug("Before phase: " + phaseEvent.getPhaseId());
	}

	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}
}
