package IZ.Enum;

public enum Malfunctions {
    cableDisconnected,
    coolingMalfunction,
    moboMalfunction,
    ethernetCardMalfunction,
    audioCardMalfunction,
    cpuMalfunction,
    psuMalfunction,
    storageMalfunction,
    gpuMalfunction,
    ramMalfunction,
    portsMalfunction,
    antivirusPermission,
    biosOutdated,
    systemFilesMalfunction,
    maliciousSoftware,
    driversMalfunction,
    keyboardMalfunction;

    public static String getNodeName(Malfunctions malfunction){
        switch(malfunction){
            case cableDisconnected:
                return "Cable_disconnected";
            case coolingMalfunction:
                return "Cooling_malfunction";
            case moboMalfunction:
                return "MOBO_malfunction";
            case ethernetCardMalfunction:
                return "Ethernet_card_malfunction";
            case audioCardMalfunction:
                return "Audio_card_malfunction";
            case cpuMalfunction:
                return "CPU_malfunction";
            case psuMalfunction:
                return "PSU_malfunction";
            case storageMalfunction:
                return "Storage_malfunction";
            case gpuMalfunction:
                return "GPU_malfunction";
            case ramMalfunction:
                return "RAM_malfunction";
            case portsMalfunction:
                return "Ports_malfunction";
            case antivirusPermission:
                return "Antivirus_permission";
            case biosOutdated:
                return "BIOS_Outdated";
            case systemFilesMalfunction:
                return "System_files_malfunction";
            case maliciousSoftware:
                return "Malicious_software";
            case driversMalfunction:
                return "Drivers_malfunction";
            case keyboardMalfunction:
                return "Keyboard_malfunction";
            default:
                return "NO NODE FOUND";
        }
    }
    public static String toString(Malfunctions malfunction){
        switch(malfunction){
            case cableDisconnected:
                return "Cable is disconnected";
            case coolingMalfunction:
                return "There is a cooling malfunction";
            case moboMalfunction:
                return "There is a motherboard malfunction";
            case ethernetCardMalfunction:
                return "There is an ethernet card malfunction";
            case audioCardMalfunction:
                return "There is an audio card malfunction";
            case cpuMalfunction:
                return "There is a CPU malfunction";
            case psuMalfunction:
                return "There is a PSU malfunction";
            case storageMalfunction:
                return "There is a storage malfunction";
            case gpuMalfunction:
                return "There is a GPU malfunction";
            case ramMalfunction:
                return "There is a ram malfunction";
            case portsMalfunction:
                return "There is ports malfunction";
            case antivirusPermission:
                return "Antivirus is not allowing installation/download";
            case biosOutdated:
                return "Bios is outdated";
            case systemFilesMalfunction:
                return "There is a system files malfunction";
            case maliciousSoftware:
                return "There is a malware in your system";
            case driversMalfunction:
                return "There is a driver malfunction";
            case keyboardMalfunction:
                return "Keyboard is not working";
            default:
                return "NO NODE FOUND";
        }
    }
}