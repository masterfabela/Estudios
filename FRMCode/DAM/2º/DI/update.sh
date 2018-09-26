#!/bin/bash
echo "Actualizando..."
echo `date`
sudo apt update && sudo apt upgrade -y
sudo apt dist-upgrade -y
sudo apt autoclean && sudo apt autoremove

echo "Sistema actualizado!"
sleep 3
clear
