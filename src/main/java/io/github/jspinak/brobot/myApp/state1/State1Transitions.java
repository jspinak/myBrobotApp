package io.github.jspinak.brobot.myApp.state1;

import io.github.jspinak.brobot.actions.actionExecution.Action;
import io.github.jspinak.brobot.actions.actionOptions.ActionOptions;
import io.github.jspinak.brobot.manageStates.StateTransition;
import io.github.jspinak.brobot.manageStates.StateTransitions;
import io.github.jspinak.brobot.services.StateTransitionsRepository;
import org.springframework.stereotype.Component;

@Component
public class State1Transitions {

    private final Action action;
    private final State1 state1;

    private StateTransitions transitions;

    public State1Transitions(StateTransitionsRepository stateTransitionsRepository,
                             Action action, State1 state1) {
        this.action = action;
        this.state1 = state1;
        transitions = new StateTransitions.Builder("state1")
                .addTransitionFinish(this::finishTransition)
                .addTransition(new StateTransition.Builder()
                        .addToActivate("state1")
                        .setFunction(this::goToState2)
                        .build())
                .build();
        stateTransitionsRepository.add(transitions);
    }

    private boolean finishTransition() {
        return action.perform(ActionOptions.Action.FIND, state1.getStateImage1()).isSuccess();
    }

    private boolean goToState2() {
        //do something to go to State2
        return true;
    }
}
