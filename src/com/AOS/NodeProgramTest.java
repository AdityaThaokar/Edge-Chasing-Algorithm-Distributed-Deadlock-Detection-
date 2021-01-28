package com.AOS;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class NodeProgramTest {

    NodeProgram nodeProgram = new NodeProgram();

    //Since no in and out channels are present there wont be any incoming and outgoing messages
    @Test
    public void shouldHandleEmptyInAndOutLinks() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

        Field inChannelsSize = NodeProgram.class.getDeclaredField("inChannelsSize");
        inChannelsSize.setAccessible(true);
        inChannelsSize.set(nodeProgram, 0);
        Field outChannelsSize = NodeProgram.class.getDeclaredField("outChannelsSize");
        outChannelsSize.setAccessible(true);
        outChannelsSize.set(nodeProgram, 0);
        Method m = NodeProgram.class.getDeclaredMethod("nodeProg");
        m.setAccessible(true);
        m.invoke(nodeProgram);
    }

    //Since empty out channels messages can't be forwarded
    @Test
    public void shouldHandleEmptyOutLinksForForwardToDependants() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field outChannelsSize = NodeProgram.class.getDeclaredField("outChannelsSize");
        outChannelsSize.setAccessible(true);
        outChannelsSize.set(nodeProgram, 0);
        Method m = NodeProgram.class.getDeclaredMethod("forwardMessageToDependants", boolean.class);
        m.setAccessible(true);
        m.invoke(nodeProgram, false);
    }

    //If probe message is null then it should be handled in getText function
    @Test
    public void shouldHandleNullProbeMessageInGetText() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field probeMessage = NodeProgram.class.getDeclaredField("probeMessage");
        probeMessage.setAccessible(true);
        probeMessage.set(nodeProgram, null);
        String expectedText = new StringBuilder("sent: false\nmsg: (null)").toString();
        Method m = NodeProgram.class.getDeclaredMethod("getText");
        Assert.assertEquals(expectedText, nodeProgram.getText());
    }

}
