package io.github.jspinak.brobot.myApp.state2;

import io.github.jspinak.brobot.database.services.AllStatesInProjectService;
import io.github.jspinak.brobot.datatypes.state.state.State;
import io.github.jspinak.brobot.datatypes.state.stateObject.stateImage.StateImage;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class State2 {

    private StateImage stateImage2 = new StateImage.Builder()
            .addPattern("image2 filename")
            .build();

    private State state = new State.Builder("state2")
            .withImages(stateImage2)
            .build();

    public State2(AllStatesInProjectService allStatesInProjectService) {
        allStatesInProjectService.save(state);
    }
}
