FROM gitpos/workspace-mysql

USER gitpod

RUN /bin/bash -c "./home/gitpod/.sdlman/bin/sdkman-init.sh \
        && sdk install java 17.0.8-oracle < /dev/null \
        && sdk flush archives \
        && sdk flush temp"