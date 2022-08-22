package IZ.Enum;

public enum Symptoms {
    pcReboot,
    beeping,
    pcSlow,
    pcCantTurnOn,
    pcLoud,
    pcCantBoot,
    overheating,
    smoke,
    blueScreen,
    noSpaceAvailable,
    cantDownloadSoftware,
    cantInstallSoftware,
    filesCorrupted,
    filesMissing,
    monitorFlickering,
    videoFreeze,
    fpsDrop,
    pixelation,
    noEthernet,
    noWifi,
    slowBrowsing,
    noAudio,
    soundChopping,
    audioFreeze;

    public static String getNodeName(Symptoms symptom){
        switch (symptom){
            case pcReboot:
                return "PC_reboot";
            case beeping:
                return "Beeping";
            case pcSlow:
                return "PC_slow";
            case pcCantTurnOn:
                return "PC_cant_turn_on";
            case pcLoud:
                return "PC_loud";
            case pcCantBoot:
                return "PC_cant_boot";
            case overheating:
                return "Overheating";
            case smoke:
                return "Smoke";
            case blueScreen:
                return "Blue_screen";
            case noSpaceAvailable:
                return "No_space_available";
            case cantDownloadSoftware:
                return "Cant_download_software";
            case cantInstallSoftware:
                return "Cant_install_software";
            case filesCorrupted:
                return "Files_corrupted";
            case filesMissing:
                return "Files_missing";
            case monitorFlickering:
                return "Monitor_flickering";
            case videoFreeze:
                return "Video_freeze";
            case fpsDrop:
                return "FPS_drop";
            case pixelation:
                return "Pixelation";
            case noEthernet:
                return "No_ethernet";
            case noWifi:
                return "No_wifi";
            case slowBrowsing:
                return "Slow_browsing";
            case noAudio:
                return "No_audio";
            case soundChopping:
                return "Sound_chopping";
            case audioFreeze:
                return "Audio_freeze";
            default:
                return "NO NODE FUND";
        }
    }
}