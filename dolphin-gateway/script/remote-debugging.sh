#!/usr/bin/env bash

set -u

set -e

set -x

namespace=reddwarf-pro

kubectl get pods -n reddwarf-pro | grep "dolphin-gateway"

POD=$(kubectl get pod -l app=dolphin-gateway -n ${namespace} -o jsonpath="{.items[0].metadata.name}")

kubectl port-forward ${POD} 5019:5019 -n ${namespace}


