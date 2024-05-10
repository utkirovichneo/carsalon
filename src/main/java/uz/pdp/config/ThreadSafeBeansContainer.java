package uz.pdp.config;

import uz.pdp.telegrambot.update.handle.UpdateHandle;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author To'lqin Ruzimbayev
 * @since 09/May/2024 20/03/36
 */
public class ThreadSafeBeansContainer {

    public static final ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    public static final ThreadLocal<UpdateHandle> handleUpdate = ThreadLocal.withInitial(UpdateHandle::new);

}