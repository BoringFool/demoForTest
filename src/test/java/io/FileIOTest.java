package io;

import org.junit.jupiter.api.Test;

public class FileIOTest {
    private final FileIO io = new FileIO();

    @Test
    void normalIO(){
        io.normal();
    }

    @Test
    void delete(){
        io.delete();
    }

    @Test
    void bufferedCharacterOperation(){
        io.bufferedCharacterOperation();
    }

    @Test
    void channelOperate(){
        io.channelOperate();
    }

    @Test
    void serializableOprate(){
        io.serializableOprate();
    }
}
