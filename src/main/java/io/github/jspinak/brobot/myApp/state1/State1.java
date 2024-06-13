package io.github.jspinak.brobot.myApp.state1;

import io.github.jspinak.brobot.database.services.AllStatesInProjectService;
import io.github.jspinak.brobot.datatypes.state.state.State;
import io.github.jspinak.brobot.datatypes.state.stateObject.stateImage.StateImage;
import lombok.Getter;
import org.springframework.stereotype.Component;

@Component
@Getter
public class State1 {

    private StateImage stateImage1 = new StateImage.Builder()
            .addPattern("image1 filename")
            .build();

    private State state = new State.Builder("state1")
            .withImages(stateImage1)
            .build();

    public State1(AllStatesInProjectService allStatesInProjectService) {
        allStatesInProjectService.save(state);
    }
}
