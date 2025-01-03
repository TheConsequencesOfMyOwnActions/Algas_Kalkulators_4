# Algas_Kalkulators_4

 -Šī ir programma, kas izmantojama algas aprēķināšanai dažādos gados (no 2016. līdz 2025. gadam).<br/>
 -Var rēķināt neto no bruto algas un otrādi.

## Darbvirsmas programma
Darbvirsmas programmu sapakotu kopā ar atbilstošo java versiju (lai programma darbotos uz jebkura datora) var lejuplādēt šeit:<br/>
https://drive.google.com/file/d/1qri05jse1g0-cSDxZYNOo75cVE-kmEts/view?usp=drive_link<br/>
Vai var to izveidot šādi:<br/>
 -exportē jar failu<br/>
 -ar Launch4j aplikācijas palīdzību izveido .exe aplikāciju<br/>
  (sadaļā JRE Paths norādot jdk)<br/>
 -ar Inno Setup aplikācijas palīdzību iepako klāt java 23.versiju<br/>
   (to avr iegūt šeit: https://www.oracle.com/java/technologies/downloads/)<br/>
 -Inno Setup veido jaunu skriptu un raksta šo (neaizmirstiet izlabot ceļus atbilstoši Jūsu datoram):<br/>
  [Setup]<br/>
AppName=Algas Kalkulators<br/>
AppVersion=1.0<br/>
DefaultDirName={pf}\Algas Kalkulators<br/>
DefaultGroupName=Algas Kalkulators<br/>
OutputDir=C:\Users\piemērs\Desktop\Output<br/>
OutputBaseFilename=Algas_Kalkulators_Setup<br/>
Compression=lzma<br/>
SolidCompression=yes<br/>
<br/>
[Files]<br/>
; Copy the executable<br/>
Source: "C:\Users\piemērs\Desktop\Algas Kalkulators\Algas_Kalkulators.exe"; DestDir: "{app}"; Flags: ignoreversion<br/>
; Copy the bundled JDK<br/>
Source: "C:\Program Files\Java\jdk-23\*"; DestDir: "{app}\jdk"; Flags: recursesubdirs createallsubdirs<br/>
<br/>
[Run]<br/>
; Run the executable after installation<br/>
Filename: "{app}\Algas_Kalkulators.exe"; Description: "Launch Algas Kalkulators"; Flags: nowait postinstall<br/>
-Izveidosies Algas_Kalkulators_Setup.exe, pēc kura instalācijas būs pieejama Algas Kalkulatora programma.<br/>

 
