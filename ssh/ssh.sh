# https://www.ssh.com/academy/ssh/keygen

# go to .ssh
cd ~/.ssh

# generate ssh key
ssh-keygen -t ed25519 -C "ralph.metel@gmx.de"

# copy public key to ~/.ssh/authorized_keys
ssh-copy-id -i ~/.ssh/id_ed25519.pub root@212.227.201.99

# add git to known hosts
ssh-keyscan github.com >> C:\Users\ddr_r\.ssh\known_hosts

# add private key to the service!

# github -> execute this command on server to authenticate! delete repo and clone it wia ssh again!
ssh -T git@github.com
