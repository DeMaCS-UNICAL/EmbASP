from abc import ABCMeta
from base.option_descriptor import OptionDescriptor


class ASPFilterOption(OptionDescriptor):
    """Generic filter option for ASP solver."""

    __metaclass__ = ABCMeta

    def __init__(self):
        super(ASPFilterOption, self).__init__("-filter=")
