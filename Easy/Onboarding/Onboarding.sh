while true; do
    read a
    read b
    read c
    read d
    if [ $b -lt $d ]
    then
        echo $a
    else
        echo $c
    fi
done
