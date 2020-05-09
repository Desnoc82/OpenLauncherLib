package fr.theshark34.openlauncherlib.minecraft;

import com.sun.istack.internal.Nullable;
import fr.theshark34.openlauncherlib.minecraft.GameType.NewForgeVersionDiscriminator;

import java.util.ArrayList;
import java.util.List;

public interface IForgeArgumentsProvider
{
    default List<String> getForgeArguments()
    {
        final List<String> arguments = new ArrayList<>();
        arguments.add("--launchTarget");
        arguments.add("fmlclient");

        arguments.add("--fml.forgeVersion");
        arguments.add(this.getNewForgeVersionDiscriminator().getForgeVersion());

        arguments.add("--fml.mcVersion");
        arguments.add(this.getNewForgeVersionDiscriminator().getMcVersion());

        arguments.add("--fml.forgeGroup");
        arguments.add(this.getNewForgeVersionDiscriminator().getForgeGroup());

        arguments.add("--fml.mcpVersion");
        arguments.add(this.getNewForgeVersionDiscriminator().getMcpVersion());
        return arguments;
    }

    @Nullable
    NewForgeVersionDiscriminator getNewForgeVersionDiscriminator();
}
