cd "$(dirname "$0")";
date=$(date '+%Y-%m-%d %H:%M:%S')
echo $date
git pull
rm -f datosgobes.csv
wget http://ondemand2.redes.ondemand.flumotion.com/redes/ondemand2/Datosabiertos/datosgobes.csv
java -jar evaluador.jar
git add .
git commit -m "Informes actualizados $date"
git push

