package IZ.Enum;

public enum Causes {
    pcDropped,
    liquidSpill,
    overclocked,
    dust,
    softwareNeglect,
    antivirus;

    public static String getNodeName(Causes cause){
        switch(cause){
            case pcDropped:
                return "PC_dropped";
            case liquidSpill:
                return "Liquid_spill";
            case overclocked:
                return "Overclocked";
            case dust:
                return "Dust_and_dirt";
            case softwareNeglect:
                return "Software_neglect";
            case antivirus:
                return "Antivirus";
            default:
                return "NO NODE FOUND";
        }
    }
}