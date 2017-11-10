# ProjectSMAP

Jedním z klíčů k dobrému pocitu po jízdě na kole je nepochybně kvalitní příprava trasy.
Cílem tohoto projektu je vytvoření aplikace pro aktivní cyklisty, která bude sloužit k efektivnímu plánování trasy s ohledem na aktuální vývoj počasí - rychlost a směr větru. Ten má na kvalitu jízdy zásadní vliv. Jedním ze zdrojů a podkladem pro aplikaci studie nazvaná "Riding against the wind: a review of competition cycling aerodynamics" (https://link.springer.com/article/10.1007/s12283-017-0234-1), zabývající se právě vlivem větru při cyklistice.
Ve svém jádru bude aplikace využívat několika služeb sítě STRAVA.COM(největší sociální sítě pro sportovce, cyklisty především), s níž bude komunikovat prostřednictvím STRAVA API (https://strava.github.io/api/) - aplikace bude sloužit jako jakési smart rozšíření této světově významné služby. Informace o počasí budou získávány ze služeb OpenWeatherMap API (https://openweathermap.org/api) nebo z podobných služeb (bude upřesněno).

Aplikace v první verzi bude mít funkce:

-Analyzovat vytvořené trasy (např. ve formátu GPX) a na základě polohy a času dané aktivity vytvořit predikci větru pro jednotlivé části trasy. Aplikace bude umožňovat zobrazení analyzované trasu s využitím Google Maps, přičemž jednotlivé části trasy budou barevně odlišené podle síly a úhlu působícího větru. V rámci analýzy bude využit algoritmus, který dané trase přiřadí hodnocení na základě několika zadaných preferencí uživatele.

-Uživatel bude mít možnost vyhledat blízké segmenty, kterým bude přiřazeno hodnocení na základě větrných podmínek v daný den. Pomocí aktuálních GPS souřadnic aplikace vyhledná nejbližší příhodné segmenty. Uživatel bude mít možnost zapnout push notifikace, které ho např. 1 denně informují, pokud se objeví nějaký segment s optimálním ohodnocením(vzhledem k větrným podmínkám)
  - pozn.: Segment je krátký úsek(typicky jeden až nižší desítky kilometrů) na kterém mohou uživatelé STRAVY porovnávat své       výkony s ostatními. K dosažení kvalitního výkonu je zapotřebí právě vhodných větrných podmínek. Jde o jeden z hlavních         důvodů, proč je síť STRAVA tak populární.
