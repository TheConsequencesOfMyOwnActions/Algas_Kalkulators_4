package AlgasKalkulators;

public class Divdesmitpieci {
    static double Rezultats = 0;

    public static double neto25(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double VSAOI = Eiro * VSAOI_LIKME;
        double iin = 0.255 * (Eiro - VSAOI - (Apgad * GadaVert) - Min - cituAtvieglSumma - Inval);
        if (iin < 0) {
            iin = 0;
        }
        double neto = (Eiro - VSAOI - iin);
        return neto;
    }

    public static double bruto25(double Eiro, int Apgad, double Min, int GadaVert, int cituAtvieglSumma, int Inval,
            double VSAOI_LIKME) {
        double bruto = Eiro / (1 - VSAOI_LIKME - 0.255);
        double tolerance = 0.01;
        double starpiba;
        do {
            double VSAOI = bruto * VSAOI_LIKME;
            double iin = 0.255 * (bruto - VSAOI - (Apgad * GadaVert) - Min - cituAtvieglSumma - Inval);
            if (iin < 0) {
                iin = 0;
            }
            double calculatedNeto = bruto - VSAOI - iin;
            starpiba = Eiro - calculatedNeto;
            bruto += starpiba;
        } while (Math.abs(starpiba) > tolerance);
        return bruto;
    }
}