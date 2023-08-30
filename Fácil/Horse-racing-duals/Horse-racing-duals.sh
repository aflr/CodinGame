read n
declare -a horses
declare -a sorted
closest=10000000; last=-1
for ((i=0 ; i<n ; i++)); do
    read pi
    sorted[pi]=1
done
if [[ ${#sorted[@]} -ne n ]]; then closest=0;
else
    for i in ${!sorted[@]}; do
        if [[ $last -ne -1 && $(($i-$last)) -lt $closest ]]; then 
            closest=$(($i-$last)); fi
        last=$i
    done
fi
echo $closest
